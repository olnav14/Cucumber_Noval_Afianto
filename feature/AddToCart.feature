Feature: Add To Cart

   #Scenario 3
  Scenario: Add_to_cart_succes
    Given User masuk ke halaman login_1
    When User mamasukan username valid_1
    And User memasukan password valid_1
    And User klik Login_1
    And User berhasil Login_1
    And User klik add to cart
    And User berhasil add to cart
    Then Cart menampilkan jumlah barang

    #Scenario 4
  Scenario: Remove_cart_succes
    Given User masuk ke halaman login_1
    When User mamasukan username valid_1
    And User memasukan password valid_1
    And User klik Login_1
    And User berhasil Login_1
    And User klik add to cart
    And User berhasil add to cart
    And User Klik Remove
    Then User berhasil Remove Item