package me.gaegul.refactoring.ch06.split_phase.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileApp {
	public static void main(String[] args) {
		try {
			System.out.println(run(args));
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
	}

	static long run(String[] args) throws IOException {
		CommandLine commandLine = parseCommandLine(args);
		return countOrders(commandLine, args);
	}

	private static CommandLine parseCommandLine(String[] args) {
		if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
		CommandLine result = new CommandLine();
		result.onlyCountReady = Stream.of(args).anyMatch(arg -> "-r".equals(arg));
		result.filename = args[args.length - 1];
		return result;
	}

	private static long countOrders(CommandLine commandLine, String[] args) throws IOException {
		File input = Paths.get(commandLine.filename).toFile();
		ObjectMapper mapper = new ObjectMapper();
		Order[] orders = mapper.readValue(input, Order[].class);

		if (commandLine.onlyCountReady) {
			return Stream.of(orders)
				.filter(o -> "ready".equals(o.status))
				.count();
		} else {
			return orders.length;
		}
	}

	static class Order {
		String status;

		Order() {
		}

		void setStatus(final String status) {
			this.status = status;
		}
	}

	private static class CommandLine {
		String filename;
		boolean onlyCountReady;
	}
}
