package Strategy;
import Strategy.IStrategy;

public class EasyStrategy implements IStrategy{


    @Override
    public int getTimeout() {
        return 3;
    }

    @Override
    public int getPlates() {
        return 15;
    }

}
