import Styles from './EmployeeCard.module.css';
import { useContext } from 'react';
import ThemeContext from './ThemeContext'; 

function EmployeeCard(props) {
  const theme = useContext(ThemeContext); 

  return (
    <div className={Styles.Card}>
      <h3>{props.employee.name}</h3>
      <p>{props.employee.email}</p>
      <p>{props.employee.phone}</p>
      <p>
        <button type="button" className={theme}>Edit</button> 
        <button type="button" className={theme}>Delete</button> 
      </p>
    </div>
  );
}

export default EmployeeCard;
