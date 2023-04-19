package me.gaegul.refactoring.ch06.split_phase.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
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
		Orders orders = OrdersReader.of(commandLine.filename()).read();
		return orders.count(commandLine.onlyCountReady());
	}

	static class Orders {
		List<Order> orders;

		Orders(final Order[] orders) {
			this.orders = Arrays.asList(orders);
		}

		private long count(boolean onlyCountReady) {
			if (!onlyCountReady) {
				return orders.size();
			}
			return orders.stream()
				.filter(Order::isReady)
				.count();
		}

	}

	static class Order {
		String status;

		Order() {}

		void setStatus(final String status) {
			this.status = status;
		}

		private boolean isReady() {
			return "ready".equals(status);
		}
	}

	static class CommandLine {
		String[] args;

		CommandLine(final String[] args) {
			if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");

			this.args = args;
		}

		boolean onlyCountReady() {
			return Stream.of(args).anyMatch(arg -> "-r".equals(arg));
		}

		String filename() {
			return args[args.length - 1];
		}
	}

	static class OrdersReader {
		private final File input;
		private final ObjectMapper mapper;

		OrdersReader(File input, ObjectMapper mapper) {
			this.input = input;
			this.mapper = new ObjectMapper();
		}

		static OrdersReader of(String filename) {
			return new OrdersReader(
				Paths.get(filename).toFile(),
				new ObjectMapper()
			);
		}

		Orders read() throws IOException {
			return new Orders(mapper.readValue(input, Order[].class));
		}
	}
}
