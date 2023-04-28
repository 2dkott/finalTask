package src.persistance;

import java.io.Closeable;
import java.io.IOException;

public class RecordAddedCounter implements Closeable {

    private int amount;

    @Override
    public void close() throws IOException {
        amount+=1;
        System.out.println(String.format("Запись № %s добавлена!", amount));
    }

    public void setRecords(int recordsAmount){
        this.amount = recordsAmount;
    }
}
