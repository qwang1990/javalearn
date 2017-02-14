package enumerated;

/**
 * Created by wangqi on 17/2/14.
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD,SOUP,SPRING_ROLLS
    }

    enum MainCourse implements Food {
        LASAGNE,BURRITO,PAD_THAI
    }

    enum Dessert implements Food {
        TIRAMISU,GELATO,FRUIT
    }
}
