package app.h1.models;

public class Report {
    private String id, title , reported_by , program, disclose_date, img;

    public Report(String id, String title, String reported_by, String program, String disclose_date, String img) {
        this.id = id;
        this.title = title;
        this.reported_by = reported_by;
        this.program = program;
        this.disclose_date = disclose_date;
        this.img = img;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReported_by() {
        return reported_by;
    }

    public String getProgram() {
        return program;
    }

    public String getDisclose_date() {
        return disclose_date;
    }

    public String getImg() {
        return img;
    }
}
