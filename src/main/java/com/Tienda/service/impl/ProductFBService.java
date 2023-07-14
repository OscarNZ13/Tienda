package com.Tienda.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.Tienda.dto.ProductFB;
import com.Tienda.firebase.FirebaseInitializer;
import com.Tienda.service.IProductFBService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Service;

@Service
public class ProductFBService implements IProductFBService{

    @Autowired
    private FirebaseInitializer firebase;

    //Enlistar:
    @Override
    public List<ProductFB> list() {
        List<ProductFB> response = new ArrayList<>();
        ProductFB product;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                product = doc.toObject(ProductFB.class);
                product.setId(doc.getId());
                response.add(product);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    //Añadir:
    @Override
    public Boolean add(ProductFB product) {
        Map<String, Object> docData = getDocData(product);

        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);

        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    //Editar:
    @Override
    public Boolean edit(String id, ProductFB product) {
        Map<String, Object> docData = getDocData(product);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    //Eliminar:
    @Override
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    //Obtener toda la coleccion:
    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("product");
    }

    private Map<String, Object> getDocData(ProductFB product) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("id", product.getId());
        docData.put("nombre", product.getNombre());
        docData.put("category", product.getCategory());
        docData.put("descripcion", product.getDescripcion());
        docData.put("detalle", product.getDetalle());
        docData.put("precio", product.getPrecio());
        docData.put("existencias", product.getExistencias());
        docData.put("ruta_imagen", product.getRuta_imagen());
        return docData;
    }

}
