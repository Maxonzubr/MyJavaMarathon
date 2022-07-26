package finalProject.gameResources;

enum FieldCell {

    EMPTY("·"), SHIP("#"), SHIP_HALO(" "), SUNKEN_SHIP("X");

    private String icon;

    FieldCell(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return icon;
    }
}
