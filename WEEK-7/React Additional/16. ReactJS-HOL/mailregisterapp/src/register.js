import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData({ ...formData, [name]: value });

    // Validation on change
    validateField(name, value);
  };

  const validateField = (name, value) => {
    let fieldErrors = { ...errors };

    switch (name) {
      case 'name':
        fieldErrors.name = value.length >= 5 ? '' : 'Name must be at least 5 characters long.';
        break;
      case 'email':
        fieldErrors.email = value.includes('@') && value.includes('.')
          ? ''
          : 'Email must contain "@" and "."';
        break;
      case 'password':
        fieldErrors.password = value.length >= 8 ? '' : 'Password must be at least 8 characters long.';
        break;
      default:
        break;
    }

    setErrors(fieldErrors);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate all fields on submit
    const newErrors = {};
    if (formData.name.length < 5) {
      newErrors.name = 'Name must be at least 5 characters long.';
    }
    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      newErrors.email = 'Email must contain "@" and "."';
    }
    if (formData.password.length < 8) {
      newErrors.password = 'Password must be at least 8 characters long.';
    }

    if (Object.keys(newErrors).length === 0) {
      alert('Form submitted successfully!');
      setFormData({ name: '', email: '', password: '' });
      setErrors({});
    } else {
      setErrors(newErrors);
    }
  };

  return (
    <div style={{ margin: '50px' }}>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name: </label><br />
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
          />
          <br />
          {errors.name && <span style={{ color: 'red' }}>{errors.name}</span>}
        </div>
        <br />
        <div>
          <label>Email: </label><br />
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
          <br />
          {errors.email && <span style={{ color: 'red' }}>{errors.email}</span>}
        </div>
        <br />
        <div>
          <label>Password: </label><br />
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
          <br />
          {errors.password && <span style={{ color: 'red' }}>{errors.password}</span>}
        </div>
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
