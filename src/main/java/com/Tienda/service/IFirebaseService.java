package com.Tienda.service;

import com.Tienda.dto.PostDTO;

import java.util.List;

public interface IFirebaseService {
    List<PostDTO> list();

    Boolean add(PostDTO post);

    Boolean edit(String id,PostDTO post);

    Boolean delete(String id);
}
