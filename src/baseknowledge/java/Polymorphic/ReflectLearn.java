package baseknowledge.java.Polymorphic;

import baseknowledge.java.Polymorphic.callback.Hello;

import java.lang.reflect.*;

public class ReflectLearn {
    public static void main(String[] args) throws Exception {

//        Object p = new Person(28) {
//            @Override
//            public boolean isInSky(FlyStatus flyStatus) {
//                return false;
//            }
//
//            @Override
//            public <T> int eat(T t) {
//                return 0;
//            }
//
//            @Override
//            public <T> int sleep(T t) {
//                return 0;
//            }
//        };
//
//        Class person = Person.class;
//        try {
//
//            Field field = person.getDeclaredField("name");
//
//            // 根据字段名,获取当前类中的字段，不包括父类中
//            System.out.println(person.getDeclaredField("age"));
//            // 根据字段名获取相应的字段，包括父类中的public字段
//            System.out.println(person.getField("speed"));
//
//            // 获取相应的字段
//            Field age = person.getDeclaredField("age");
//            try {
//                // 不管这个字段是不是private都允许访问
//                age.setAccessible(true);
//                // 使用这个方法来设置字段值，如果设置非public的字段，需要设置一下，setAccessible为true
//                age.set(person,60);
//                Object value = age.get(p);
//                System.out.println(value);
//            } catch (IllegalAccessException e) {
//                System.out.println("发生异常");
//                e.printStackTrace();
//            }
//            System.out.println(age.getName());
//            System.out.println(age.getType());
//            int m = age.getModifiers();
//            System.out.println(Modifier.isFinal(m));
//            System.out.println(Modifier.isPublic(m));
//            System.out.println(Modifier.isPrivate(m));
//            System.out.println(Modifier.isProtected(m));
//            System.out.println(Modifier.isStatic(m));
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//      todo：如果是多个字段时，会不会产生什么问题
        Object p = new Student(45);
        Class student = p.getClass();
        // 利用反射拿到字段的一个Field实例
        Field f = student.getDeclaredField("age");
        // 如果需要对private字段进行操作，那么设置setAccessible为true
        f.setAccessible(true);
        //  设置相应字段的值
        f.set(p, 80);
        // 获取相应的数据值
        Object value = f.get(p);
        System.out.println("value :" + value);


        // 反射Method对象的获取，分别获取public方法、继承的public方法以及private方法
        Class lowGradeStudent = LowGradeStudent.class;
        System.out.println(lowGradeStudent.getMethod("getAge"));
        System.out.println(lowGradeStudent.getMethod("getAvScore", int.class));
        System.out.println(lowGradeStudent.getDeclaredMethod("getGrade", int.class));

        LowGradeStudent lowGradeStudent1 = new LowGradeStudent();

        // 调用普通public方法
        Method m = lowGradeStudent.getMethod("getAvScore", int.class);
        int score = (int) m.invoke(lowGradeStudent1, 90);
        System.out.println(score);

        // 调用静态方法
        Method m1 = lowGradeStudent.getMethod("getMessage", String.class);
        String info = (String) m1.invoke(null, "一位阳光帅气的小伙子");
        System.out.println(info);

        // 调用非public方法
        Method m2 = lowGradeStudent.getDeclaredMethod("setName", String.class);
        m2.setAccessible(true);
        m2.invoke(lowGradeStudent1, "Shaoronggang");
        System.out.println(lowGradeStudent1.name);

        // 多态：遵循多态原则：即总是调用实际类型的覆写方法（如果存在）
        Method m3 = lowGradeStudent.getMethod("hello");
        m3.invoke(lowGradeStudent1);


        // 动态代理 创建一个InvocationHandler来处理
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")){
                    System.out.println("Good morning " + args[0]);
                }
                return null;
            }
        };

        // 使用Proxy.newProxyInstance来创建接口实例
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),// 传入ClassLoader
                new Class[]{Hello.class},// 传入要实现的接口
                handler
                );
        hello.morning(12);



    }


}

