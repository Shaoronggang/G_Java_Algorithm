package baseknowledge.java.Polymorphic;

import java.util.*;

/**
 * java中集合学习
 */
public class ConnectionLearn {
    public static void main(String[] args) {


        /*-----------------------------List集合数据处理------------------------------*/
        ArrayList<String> list = new ArrayList();
        list.add("shaoronggang");
        list.add("Jhon");
        ConnectionLearn learn = new ConnectionLearn();
        learn.getElements(list);
        /*-----------------------------List集合数据处理------------------------------*/

        /*-----------------------------Map集合数据处理------------------------------*/
//        Map<String, String> mapFruit = new HashMap<>(); //hashMap  无序的
        Map<String, String> mapFruit = new TreeMap<>(); // TreeMap 有序的
        mapFruit.put("orange", "delicious");
        mapFruit.put("balana", "good");
        mapFruit.put("apple", "red");
//        遍历map
        for (Map.Entry<String, String> key : mapFruit.entrySet()
        ) {
            String keyName = key.getKey();
            String value = key.getValue();
            System.out.println(keyName + ":" + value);

        }
        /*-----------------------------Map集合数据处理------------------------------*/

        /*-----------------------------Set集合数据处理------------------------------*/
//        Set<String> fruitSet = new HashSet<>();
        Set<String> fruitSet = new TreeSet<>();
        fruitSet.add("pear");
        fruitSet.add("banana");
        fruitSet.add("mango");
        System.out.println(fruitSet.contains("apple"));
        for (String s : fruitSet
        ) {
            System.out.println(s);
        }

        /*-----------------------------Set集合数据处理------------------------------*/

        /*-----------------------------Queue集合数据处理------------------------------*/
        Queue<String> qUeue = new LinkedList<>();
        qUeue.offer("apple");
        qUeue.offer("pear");
        qUeue.offer("banana");
//        取出并删除
//        System.out.println(qUeue.poll());
//        System.out.println(qUeue.poll());
//        System.out.println(qUeue.poll());
//        System.out.println(qUeue.poll());
//      取出但不删除
        System.out.println(qUeue.peek());
        System.out.println(qUeue.peek());
        System.out.println(qUeue.peek());
        System.out.println(qUeue.peek());
        /*-----------------------------Queue集合数据处理------------------------------*/


    }

    private void getElements(List list) {
//      使用迭代器来遍历List
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }


}
