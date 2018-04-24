package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Teun
 */
@Entity
public class Journey implements Serializable {

    @Id
    private Long id;
    private final List<TransLocation> locations = new ArrayList<>();

    public Journey() {
    }

    public long getId() {
        return id;
    }
    
    public List<TransLocation> getTransLocations() {
        return Collections.unmodifiableList(locations);
    }

    // </editor-fold>

    public boolean addTransLocation(TransLocation loc) {
        if (loc != null) {
            locations.add(loc);
            return true;
        }
        return false;
    }

    public boolean addTransLocation(List<TransLocation> loc) {
        if (loc != null) {
            locations.addAll(loc);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Journey)) {
            return false;
        }
        Journey otherUser = (Journey) obj;
        if (this.id == null || otherUser.id == null) {
            return false;
        }
        return this.id.equals(otherUser.id);
    }

    @Override
    public int hashCode() {
        int hash = 2;
        hash = 12 * hash + Objects.hashCode(this.id);
        hash = 12 * hash + Objects.hashCode(this.locations);
        return hash;
    }
}
