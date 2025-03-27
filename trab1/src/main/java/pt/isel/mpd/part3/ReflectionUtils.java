package pt.isel.mpd.part3;


import java.lang.reflect.*;
import java.util.*;

public class ReflectionUtils {
    
    /**
     * Check if a type (class or interface)
     * implements directly or indirectly an interface or any of its super interfaces
     * @param type
     * @param interfaceType
     * @return
     */
    public static boolean implementsInterface(Class<?> type, Class<?> interfaceType) {
        var curr = type;
        do {
            if (curr == interfaceType)
                return true;
            for (var iType : curr.getInterfaces()) {
                if (implementsInterface(iType, interfaceType))
                    return true;
            }
            if (curr.isInterface())
                break;
            curr = curr.getSuperclass();
        }
        while(curr != Object.class);
        return false;
    }
    
    /**
     * Check if a class is the same or a subclass of another class
     * @param cls
     * @param superCls
     * @return
     */
    public static boolean isSameOrSubClass(Class<?> cls, Class<?> superCls) {
        var curr = cls;
        while(curr != null) {
            if (curr.equals(superCls)) return true;
            curr = curr.getSuperclass();
        }
        return false;
    }
    
    /**
     * Check if an object class is compatible with
     * a certain type (class or interface)
     * This has a behaviour similar to the Java instanceof operator
     * @param obj
     * @param type
     * @return
     */
    public static boolean isInstanceOf(Object obj, Class<?> type) {
        Class<?> objClass = obj.getClass();
        if (type.isInterface()) {
            return implementsInterface(objClass, type);
        }
        else {
            return isSameOrSubClass(objClass, type);
        }
    }

    /**
     * check if class "cls" is an abstract class
     * @param cls
     * @return
     */
    public static boolean isAbstract(Class<?> cls) {
        return Modifier.isAbstract(cls.getModifiers());
    }
    
    /**
     * check if class "cls" is an array class
     * @param cls
     * @return
     */
    public static boolean isArray(Class<?> cls) {
        return cls.isArray();
    }
    
    /**
     * check if class "cls" is a String class
     * @param cls
     * @return
     */
    public static boolean isString(Class<?> cls) {
        return cls == String.class;
    }
    
    /**
     * check if class "cls" implements Collection interface
     * @param cls
     * @return
     */
    public static boolean  isCollection(Class<?> cls) {
        return implementsInterface(cls, Collection.class);
    }
    
    /**
     * check if class "cls" represents a primitive type (ex: int or long)
     * @param cls
     * @return
     */
    public static boolean  isPrimitive(Class<?> cls) {
        return cls.isPrimitive();
    }
    
    /**
     * check if class "cls" represents an Enum type
     * @param cls
     * @return
     */
    public static boolean isEnum(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
    
   
    /**
     * fields
     */
    
    /**
     * Get a list with all fields (public or not, inherited or not)
     * of instances of class "cls"
     * @param cls
     * @return
     */
    public static List<Field>  getAllFields(Class<?> cls) {
        var fields = new ArrayList<Field>();
        while (cls != null) {
            fields.addAll(Arrays.asList(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }
        return fields;
    }
    
    
    public static List<Field> getAllFields(Object obj) {
        return getAllFields(obj.getClass());
    }
    
    /**
     * check if a certain Member "member" is static
     * @param member
     * @return
     */
    public static boolean isStatic(Member member) {
        return Modifier.isStatic(member.getModifiers());
    }
    
    /**
     * check if "member" represents a private member
     * @param member
     * @return
     */
    public static boolean isPrivate(Member member) {
        return Modifier.isPrivate(member.getModifiers());
    }
    
    /**
     * check if "member" represents a public member
     * @param member
     * @return
     */
    public static boolean isPublic(Member member) {
        return Modifier.isPublic(member.getModifiers());
    }
    
    /**
     * check if "member" represents a protected member
     * @param member
     * @return
     */
    public static boolean isProtected(Member member) {
        return Modifier.isProtected(member.getModifiers());
    }
}
