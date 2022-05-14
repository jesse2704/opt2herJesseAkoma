package src;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public class Huurder extends Gebruiker {

    public Collection<VerhuurFragment> fragment;
    public Licentie licentie;

    public Huurder(String userName, String emailAddress, String password, String firstName, String lastName, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.userName = emailAddress;
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.licentie = null;
        this.fragment = new Collection<VerhuurFragment>() {
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
            public Iterator<VerhuurFragment> iterator() {
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
            public boolean add(VerhuurFragment verhuurFragment) {
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
            public boolean addAll(Collection<? extends VerhuurFragment> c) {
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
}
