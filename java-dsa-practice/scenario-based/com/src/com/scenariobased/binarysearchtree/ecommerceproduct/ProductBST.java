package com.scenariobased.binarysearchtree.ecommerceproduct;

public class ProductBST {
    ProductNode root;

    // Insert product
    public void insert(int sku, String name, double price) {
        root = insertRec(root, sku, name, price);
    }

    private ProductNode insertRec(ProductNode root, int sku, String name, double price) {
        if (root == null)
            return new ProductNode(sku, name, price);

        if (sku < root.sku)
            root.left = insertRec(root.left, sku, name, price);
        else if (sku > root.sku)
            root.right = insertRec(root.right, sku, name, price);

        return root;
    }

    // Search product by SKU
    public ProductNode search(int sku) {
        return searchRec(root, sku);
    }

    private ProductNode searchRec(ProductNode root, int sku) {
        if (root == null || root.sku == sku)
            return root;

        if (sku < root.sku)
            return searchRec(root.left, sku);

        return searchRec(root.right, sku);
    }

    // Update price
    public void updatePrice(int sku, double newPrice) {
        ProductNode product = search(sku);
        if (product != null) {
            product.price = newPrice;
        }
    }

    // Display products in sorted SKU order
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(ProductNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("SKU: " + root.sku +
                               ", Name: " + root.name +
                               ", Price: ₹" + root.price);
            inorderRec(root.right);
        }
    }
}
