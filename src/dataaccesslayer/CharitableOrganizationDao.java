package dataaccesslayer;

import java.util.List;

import model.CharitableOrganization;

public interface CharitableOrganizationDao {
    void save(CharitableOrganization organization);
    void update(CharitableOrganization organization);
    void delete(int organizationId);
    CharitableOrganization getCharitableOrganizationByEmail(String email);
    List<CharitableOrganization> getAllCharitableOrganizations();
}
