package collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {
        return new HashSet<>(stringCollection);
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {
//        Set<String> result = new HashSet<>(setA);
//        result.addAll(setB);
//        for (String s : setA) {
//            if (!setB.contains(s)){
//                result.add(s);
//            }
//        }
        setA.retainAll(setB);
        return setA;
    }
}
