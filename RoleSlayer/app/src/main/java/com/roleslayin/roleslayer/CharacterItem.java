package com.roleslayin.roleslayer;

public class CharacterItem {

    public CharacterItem(){}
    public CharacterItem(String name, String descr, String type, int dmg, int weight) {
        this.itemName = name;
        this.itemDescr = descr;
        this.itemType = type;
        this.itemDmg = dmg;
        this.itemWeight = weight;
    }

    private String itemName;
    private String itemDescr;
    private String itemType;
    private int itemDmg;
    private int itemWeight;


    public int getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescr() {
        return itemDescr;
    }

    public void setItemDescr(String itemDescr) {
        this.itemDescr = itemDescr;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemDmg() {
        return itemDmg;
    }

    public void setItemDmg(int itemDmg) {
        this.itemDmg = itemDmg;
    }

}
