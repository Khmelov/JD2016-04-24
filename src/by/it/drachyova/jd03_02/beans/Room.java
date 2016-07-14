package by.it.drachyova.jd03_02.beans;

public class Room {
    private String type;
    private int price;
    private boolean isAvailable;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Room() {
    }

    public Room(String type, int price, boolean isAvailable) {
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (getPrice() != room.getPrice()) return false;
        if (isAvailable() != room.isAvailable()) return false;
        if (!getType().equals(room.getType())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getPrice();
        result = 31 * result + (isAvailable() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
