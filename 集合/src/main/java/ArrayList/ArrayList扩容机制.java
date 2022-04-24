package ArrayList;

import sun.security.util.Length;

import java.util.ArrayList;

/**
 * @author zxy
 * @Classname arrayList
 * @Date 2022/4/12 20:11
 */
public class ArrayList扩容机制 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList(3);



        for (int i = 0; i < 4; i++) {
            list.add(""+i);
        }

        System.out.println(length(list));

    }

}
