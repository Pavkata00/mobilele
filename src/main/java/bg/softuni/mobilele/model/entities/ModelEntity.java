package bg.softuni.mobilele.model.entities;

import bg.softuni.mobilele.model.entities.enums.ModelCategoryEnum;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="models")
public class ModelEntity extends BaseEntity {

  private String name;

  @Enumerated(EnumType.STRING)
  private ModelCategoryEnum category;

  @Column(length = 512)
  private String imageUrl;

  private int startYear;

  private Integer endYear;

  @ManyToOne
  private BrandEntity brand;

  public String getName() {
    return name;
  }

  public ModelEntity setName(String name) {
    this.name = name;
    return this;
  }

  public ModelCategoryEnum getCategory() {
    return category;
  }

  public ModelEntity setCategory(ModelCategoryEnum category) {
    this.category = category;
    return this;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public ModelEntity setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public int getStartYear() {
    return startYear;
  }

  public ModelEntity setStartYear(Integer startYear) {
    this.startYear = startYear;
    return this;
  }

  public Integer getEndYear() {
    return endYear;
  }

  public ModelEntity setEndYear(int endYar) {
    this.endYear = endYar;
    return this;
  }

  public BrandEntity getBrand() {
    return brand;
  }

  public ModelEntity setBrand(BrandEntity brand) {
    this.brand = brand;
    return this;
  }

  @Override
  public String toString() {
    return "ModelEntity{" +
        "name='" + name + '\'' +
        ", category=" + category +
        ", imageUrl='" + imageUrl + '\'' +
        ", startYear=" + startYear +
        ", endYar=" + endYear +
        ", brand=" + brand +
        ", id=" + id +
        ", created=" + created +
        ", updated=" + updated +
        '}';
  }
}
