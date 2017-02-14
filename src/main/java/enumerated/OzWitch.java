package enumerated;

/**
 * Created by wangqi on 17/2/14.
 */
public enum OzWitch {
    WEST("Miss Gluch,aka"),
    NORTH("Glinda, the Good"),
    EAST("eeee"),
    SOUTH("Good by inference");

    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": "+witch.getDescription());
        }
    }

}
