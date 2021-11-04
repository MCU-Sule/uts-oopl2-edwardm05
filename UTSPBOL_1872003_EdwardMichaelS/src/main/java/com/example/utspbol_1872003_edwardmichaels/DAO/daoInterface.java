package com.example.utspbol_1872003_edwardmichaels.DAO;

import java.util.List;
//1872003 - Edward Michael S
public interface daoInterface<E> {
    public int addData(E data);

    public int delData(E data);

    public int updateData(E data);

    public List<E> showData();
}
