import java.util.ArrayList;

public class conveyor {

    ArrayList<Executor> executors = new ArrayList<Executor>();


    public void addExecutor(Executor excc) {

        executors.add(excc);

    }

    public void run() {
        Executor Source = executors.get(0);
        ArrayList<Executor> remaningExecutors = new ArrayList<Executor>(executors.subList(1, executors.size() - 1));
        Object val = null;

        while (true) {
            try {
                val = Source.execute(null);

            } catch (Exception e) {
                break;
            }

            for (Executor item : remaningExecutors) {
                try {
                    val = item.execute(val);
                } catch (Exception e) {
                    break;
                }
            }
        }


    }
}
// Executor's execute should receive an Object and return an Object
//Source should raise an exception on its completion-SourceExhaustedException