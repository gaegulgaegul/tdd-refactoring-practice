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
		return countOrder(new CommandLine(args));
	}

	private static long countOrder(CommandLine commandLine) throws IOException {
		File input = Paths.get(commandLine.filename()).toFile();
		ObjectMapper mapper = new ObjectMapper();
		Order[] orders = mapper.readValue(input, Order[].class);
		if (commandLine.onlyCountReady()) {
			return Stream.of(orders)
				.filter(o -> "ready".equals(o.status))
				.count();
		} else {
			return orders.length;
		}
	}

	static class Order {
		String status;

		Order() {}

		void setStatus(final String status) {
			this.status = status;
		}
	}

	private static class CommandLine {
		String[] args;

		CommandLine(final String[] args) {
			if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");

			this.args = args;
		}

		private boolean onlyCountReady() {
			return Stream.of(args).anyMatch(arg -> "-r".equals(arg));
		}

		private String filename() {
			return args[args.length - 1];
		}
	}
}
