package com.dao;

import java.util.List;

import com.model.Inv_Trans;

public interface Inv_TransDAO {
    public void saveInv_Trans(Inv_Trans inv_trans);
    public void deleteinv_Trans();
    public List<Inv_Trans> listAllInv_Trans();
    public List<Inv_Trans> listInv_TransById(int id);
}
