package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="car")
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }

   public Long getId() {
      return id;
   }
   public String getFirstName() {
      return firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public String getEmail() {
      return email;
   }
   public Car getCar() { return car; }



   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      User user = (User) o;

      if (!id.equals(user.id)) return false;
      if (!firstName.equals(user.firstName)) return false;
      if (!lastName.equals(user.lastName)) return false;
      if (!email.equals(user.email)) return false;
      return car != null ? car.equals(user.car) : user.car == null;
   }

   @Override
   public int hashCode() {
      int result = id.hashCode();
      result = 31 * result + firstName.hashCode();
      result = 31 * result + lastName.hashCode();
      result = 31 * result + email.hashCode();
      result = 31 * result + (car != null ? car.hashCode() : 0);
      return result;
   }
}
