package model;

import java.time.Instant;
import java.util.UUID;


public class Expense {

    private UUID id;
    private String name;
    private String description;
    private float amount;
    private Instant timestamp;

    public Expense() {
    }

    public Expense(UUID id, String name, String description, float amount, Instant timestamp) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "-----" + "\n" +
        "ID:" + this.id.toString() + "\n" +
        "Name: " + this.name + "\n" +
        "Description: " + this.description + "\n" +
        "Amount: " + this.amount + "\n" +
        "Timestamp: " + this.timestamp;
    }

}
