import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List<Integer> list = new ArrayList<Integer>();


    public void add(Integer i) {
        this.list.add(i);

    }

    public void remove(Integer i) {
        this.list.remove(i);

    }

    public boolean contains(Integer i) {
        return this.list.contains(i);
    }

    public String print() {
        return list.toString();
    }

    public void replace(Integer oldNumber, Integer newNumber) {
        int index = list.indexOf(oldNumber);
        if (index==-1){
            return;
        }
        else{
            list.set(index, newNumber);
        }


    }


}


