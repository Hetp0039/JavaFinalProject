package dataaccesslayer;

import java.util.List;

import model.Claim;

public interface ClaimDao {
    void save(Claim claim);
    List<Claim> getAllClaims();
}

