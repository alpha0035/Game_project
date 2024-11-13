package items;

import static constants.Constants.SCALE;
import static items.Fruit.FRUIT_DEFAULT_SIZE;

public class SpecificFruit {
    public int fruit, x, y, w, h;
    public SpecificFruit(int fruit, int x, int y)
    {
        this.fruit = fruit;
        this.x = x;
        this.y = y;
        w = (int)(FRUIT_DEFAULT_SIZE[fruit][0]*SCALE);
        h = (int)(FRUIT_DEFAULT_SIZE[fruit][1]*SCALE);
    }
}
