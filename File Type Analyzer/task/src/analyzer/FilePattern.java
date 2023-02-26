package analyzer;

public class FilePattern {
    public int prio;
    public String pattern;
    public String message;

    FilePattern(int prio, String pattern, String message){
        this.prio = prio;
        this.pattern = pattern;
        this.message = message;
    }
}
