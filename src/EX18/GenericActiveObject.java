package EX18;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GenericActiveObject {
    Object o;

    ConcurrentHashMap<String, ParamRunnable> map;
    ExecutorService executorService;
    public GenericActiveObject(Object o){
        this.o = o;
        map = new ConcurrentHashMap<>();
        executorService = Executors.newSingleThreadExecutor();
        for (Method method: o.getClass().getMethods()){
            map.put(method.getName(),args -> {
                try {
                    method.invoke(o,args);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public void execute(String name, Object...args){
        executorService.execute(()->map.get(name).run(args));
    }

    public void shutdown(){
        executorService.shutdown();
    }


}
