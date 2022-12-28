import entity.City;
import repository.GenericRepository;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");

        GenericRepository repository = new GenericRepository();
        repository.setEntity(City.class);
        repository.getConnection();
    }
}