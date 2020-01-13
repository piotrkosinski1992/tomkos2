import {Category} from "./Category";

export class Product {
  id: string;
  category: Category;
  name: string;
  description: string;
  price: number;


  constructor(id: string, category: Category, name: string, description: string, price: number) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.description = description;
    this.price = price;
  }
}
