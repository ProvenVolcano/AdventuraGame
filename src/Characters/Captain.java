package Characters;

public class Captain extends Character {

    public Captain(String fileName) {
        super(fileName);
    }

    @Override
    public String talk() {
        switch (dialogIndex){
            case 0:
                dialogIndex++;
                return dialogs.get(0);
            case 1:
                return dialogs.get(1);
            default:
                return "";
        }
    }
}
