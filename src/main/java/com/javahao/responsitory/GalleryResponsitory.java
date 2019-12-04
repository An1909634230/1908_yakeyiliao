package com.javahao.responsitory;

import com.javahao.pojo.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anzIhao on 2019/12/3.
 */
public interface GalleryResponsitory extends JpaRepository<Gallery, Integer> {
  public   Gallery findGalleryBysid(Integer sid);
}
