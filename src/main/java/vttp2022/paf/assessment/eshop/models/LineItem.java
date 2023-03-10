package vttp2022.paf.assessment.eshop.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

// DO NOT CHANGE THIS CLASS
public class LineItem {

	private String item;
	private Integer quantity;

	public String getItem() { return this.item; }
	public void setItem(String item) { this.item = item; }

	public Integer getQuantity() { return this.quantity; }
	public void setQuantity(Integer quantity) { this.quantity = quantity; }

	public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("item", this.getItem())
                .add("quantity", this.getQuantity().toString())
                .build();
    }
}
