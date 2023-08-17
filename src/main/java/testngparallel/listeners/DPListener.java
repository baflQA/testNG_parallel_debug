package testngparallel.listeners;

import org.testng.IDataProviderListener;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.lang.reflect.InvocationTargetException;

public class DPListener implements IDataProviderListener {

    @Override
    public void onDataProviderFailure(ITestNGMethod method, ITestContext ctx, RuntimeException t) {
        try {
            method.getDataProviderMethod().getMethod().invoke(method.getRealClass().getDeclaredConstructor().newInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}