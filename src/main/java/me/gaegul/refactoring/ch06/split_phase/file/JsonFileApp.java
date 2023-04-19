package me.gaegul.refactoring.ch06.split_phase.file;

import java.io.File;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileApp {
	public static void main(String[] args) {
		try {
			if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
			String filename = args[args.length - 1];
			File input = Paths.get(filename).toFile();

			ObjectMapper mapper = new ObjectMapper();
			Order[] orders = mapper.readValue(input, Order[].class);
			if (Stream.of(args).anyMatch(arg -> "-r".equals(arg))) {
				System.out.println(Stream.of(orders)
						.filter(o -> "ready".equals(o.status))
						.count());
			} else {
				System.out.println(orders.length);
			}
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
	}

	private static class Order {
		String status;
	}
}
