package Cerner;

import java.util.Comparator;

public class LastSeenDateComparator implements Comparator<Patient> {

        @Override
        public int compare( Patient p1, Patient p2 ){
            return p2.getLastSeen().compareTo(p1.getLastSeen());
        }
}

