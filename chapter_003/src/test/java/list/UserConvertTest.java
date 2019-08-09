package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListToHashMap() {
        HashMap<Integer, User> resultMap;
        List<User> list = new ArrayList<>();
        UserConvert uc = new UserConvert();
        list.addAll(Arrays.asList(new User(1, "Roman", "Kstovo"), new User(2, "Ivan", "Moscow"), new User(3, "Andrew", "Rostov")));
        resultMap = uc.process(list);
        assertThat(resultMap.get(1).name, is("Roman"));
        assertThat(resultMap.get(2).name, is("Ivan"));
        assertThat(resultMap.get(3).name, is("Andrew"));
    }
}