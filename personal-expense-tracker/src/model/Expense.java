package model;

import java.time.Instant;
import java.util.UUID;


public record Expense(UUID id, String name, Category category, float amount, Instant timestamp) {
}

// public class Expense {

//     private UUID id;
//     private String name;
//     private Category category;
//     private float amount;
//     private Instant timestamp;

//     public Expense() {
//     }

//     public Expense(UUID id, String name, Category category, float amount, Instant timestamp) {
//         this.id = id;
//         this.name = name;
//         this.category = category;
//         this.amount = amount;
//         this.timestamp = timestamp;
//     }

//     public UUID getId() {
//         return this.id;
//     }

//     public void setId(UUID id) {
//         this.id = id;
//     }

//     public String getName() {
//         return this.name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Category getCategory() {
//         return this.category;
//     }

//     public void setCategory(Category category) {
//         this.category = category;
//     }

//     public float getAmount() {
//         return this.amount;
//     }

//     public void setAmount(float amount) {
//         this.amount = amount;
//     }

//     public Instant getTimestamp() {
//         return this.timestamp;
//     }

//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
//     }

//     @Override
//     public String toString(){
//         return "-----" + "\n" +
//         "ID:" + id.toString() + "\n" +
//         "Name: " + name + "\n" +
//         "Category: " + category.toString() + "\n" +
//         "Amount: " + amount + "\n" +
//         "Timestamp: " + timestamp;
//     }

// }
