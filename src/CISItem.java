public class CISItem {
    private String name;
    private String location;
    private int price;
    private String description;

    public void setLocation(String a){
        location = a;
    }

    public String getLocation(){
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
