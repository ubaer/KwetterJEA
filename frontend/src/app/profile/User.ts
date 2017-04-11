/**
 * Created by Kevin on 11-4-2017.
 */
export interface User {
  userName:string;
  bio:string;
  createDate:string;
  followers:[User];
}
