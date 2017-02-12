package generics;

/**
 * Created by wangqi on 17/2/12.
 */
class GenericType<T> {}
public class CurriouslyRecurringGeneric
        extends GenericType<CurriouslyRecurringGeneric> {}
