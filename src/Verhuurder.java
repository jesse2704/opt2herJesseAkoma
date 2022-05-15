package src;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public class Verhuurder extends Gebruiker {
    public Collection<Auto> Autos;

    public Verhuurder(String userName, String emailAddress, String password, String firstName, String lastName, String phoneNumber) {
        super(userName, emailAddress, password, firstName, lastName, phoneNumber);
        this.Autos = new Collection<Auto>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Auto> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Auto auto) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Auto> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }

    public Collection<Auto> getAutos() {
        return Autos;
    }

    public void addAuto(String merk)
    {
        getAutos().add(new Auto(merk));
    }

}
