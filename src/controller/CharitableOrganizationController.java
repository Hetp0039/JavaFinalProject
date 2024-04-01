package controller;

import java.util.List;

import dataaccesslayer.CharitableOrganizationDao;
import model.CharitableOrganization;

public class CharitableOrganizationController {
    private final CharitableOrganizationDao charitableOrganizationDao;

    public CharitableOrganizationController(CharitableOrganizationDao charitableOrganizationDao) {
        this.charitableOrganizationDao = charitableOrganizationDao;
    }

    public void registerCharitableOrganization(CharitableOrganization organization) {
        charitableOrganizationDao.save(organization);
    }

    public CharitableOrganization getCharitableOrganizationByEmail(String email) {
        return charitableOrganizationDao.getCharitableOrganizationByEmail(email);
    }

    public void updateCharitableOrganization(CharitableOrganization organization) {
        charitableOrganizationDao.update(organization);
    }

    public void deleteCharitableOrganization(int organizationId) {
        charitableOrganizationDao.delete(organizationId);
    }

    public List<CharitableOrganization> getAllCharitableOrganizations() {
        return charitableOrganizationDao.getAllCharitableOrganizations();
    }
}

