package com.pluralsight.Service;

import com.pluralsight.Models.Order;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class OrderService {

    public static void saveOrderToFile(Order order) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        String directory = "OrderReceipts";
        String filename = directory +"/" + timestamp + ".txt";


        if (!Files.exists(Paths.get(directory))) {
            Files.createDirectories(Paths.get(directory));
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(order.getOrderDetails());
        }
    }
}

