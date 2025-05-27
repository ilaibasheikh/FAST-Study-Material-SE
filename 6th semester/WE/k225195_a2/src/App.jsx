import React, { useState } from 'react';
import './App.css';

const GradeCalculator = () => {
  const [coursesList, setCoursesList] = useState([{ name: '', hours: '', grade: '' }]);
  const [calculatedGpa, setCalculatedGpa] = useState(0);
  const [validationErrors, setValidationErrors] = useState([]);
  const [hasCalculated, setHasCalculated] = useState(false);

  const gradeScale = {
    F: 0.0,
    D: 1.0,
    'D+': 1.33,
    'C-': 1.66,
    C: 2.0,
    'C+': 2.33,
    'B-': 2.66,
    B: 3.0,
    'B+': 3.33,
    'A-': 3.66,
    A: 4.0,
    'A+': 4.0,
  };

  const addNewCourse = () => {
    if (coursesList.length < 10) {
      setCoursesList([...coursesList, { name: '', hours: '', grade: '' }]);
    }
  };

  const removeCourse = (index) => {
    if (coursesList.length > 1) {
      const updatedCoursesList = coursesList.filter((_, idx) => idx !== index);
      setCoursesList(updatedCoursesList);
    }
  };

  const handleInputChange = (e, index) => {
    const { name, value } = e.target;
    const updatedCourses = [...coursesList];
    updatedCourses[index][name] = value;
    setCoursesList(updatedCourses);
  };

  const validateCourseData = (courses) => {
    const errors = [];

    courses.forEach((course, index) => {
      if (!course.name || !/^[A-Za-z\s]+$/.test(course.name)) {
        errors[index] = errors[index] || {};
        errors[index].name = 'Course name must contain only letters and cannot be empty.';
      } else {
        errors[index] = errors[index] || {};
        delete errors[index].name;
      }

      if (isNaN(course.hours) || course.hours <= 0 || !Number.isInteger(Number(course.hours))) {
        errors[index] = errors[index] || {};
        errors[index].hours = 'Credit hours should be a positive integer.';
      } else {
        errors[index] = errors[index] || {};
        delete errors[index].hours;
      }

      if (!course.grade) {
        errors[index] = errors[index] || {};
        errors[index].grade = 'Grade is mandatory.';
      } else {
        errors[index] = errors[index] || {};
        delete errors[index].grade;
      }
    });

    setValidationErrors(errors);
    return errors;
  };

  const computeGPA = () => {
    const errors = validateCourseData(coursesList);

    if (Object.values(errors).some((error) => error && Object.keys(error).length > 0)) {
      setHasCalculated(false);
      return;
    }

    const totalPoints = coursesList.reduce((total, course) => {
      const gradePoints = gradeScale[course.grade] || 0;
      return total + gradePoints * course.hours;
    }, 0);

    const totalHours = coursesList.reduce((total, course) => total + parseFloat(course.hours), 0);

    if (totalHours > 0) {
      setCalculatedGpa(totalPoints / totalHours);
      setHasCalculated(true);
    } else {
      setCalculatedGpa(0);
      setHasCalculated(true);
    }
  };

  return (
    <div className="container">
      <div className="calculator-box">
        <h1 className="title">GPA Calculator</h1>

        {coursesList.map((course, index) => (
          <div key={index} className="course-row">
            <div className="input-group">
              <input
                type="text"
                name="name"
                value={course.name}
                onChange={(e) => handleInputChange(e, index)}
                placeholder="Course Name"
                className={`input ${validationErrors[index]?.name ? 'input-error' : ''}`}
                required
              />
              {validationErrors[index]?.name && (
                <p className="error-text">{validationErrors[index].name}</p>
              )}
            </div>

            <div className="input-group">
              <input
                type="number"
                name="hours"
                value={course.hours}
                onChange={(e) => handleInputChange(e, index)}
                placeholder="Credit Hours"
                className={`input ${validationErrors[index]?.hours ? 'input-error' : ''}`}
                min="1"
                max="3"
                required
              />
              {validationErrors[index]?.hours && (
                <p className="error-text">{validationErrors[index].hours}</p>
              )}
            </div>

            <div className="input-group">
              <select
                name="grade"
                value={course.grade}
                onChange={(e) => handleInputChange(e, index)}
                className={`input ${validationErrors[index]?.grade ? 'input-error' : ''}`}
                required
              >
                <option value="">Select Grade</option>
                {Object.keys(gradeScale).map((grade) => (
                  <option key={grade} value={grade}>
                    {grade}
                  </option>
                ))}
              </select>
              {validationErrors[index]?.grade && (
                <p className="error-text">{validationErrors[index].grade}</p>
              )}
            </div>

            <button
              type="button"
              className="remove-course-btn"
              onClick={() => removeCourse(index)}
            >
              -
            </button>
          </div>
        ))}

        <div className="buttons">
          <button
            className="add-course-btn"
            onClick={addNewCourse}
            disabled={coursesList.length >= 10}
          >
            Add Course
          </button>

          <button
            className="calculate-btn"
            onClick={computeGPA}
          >
            Calculate GPA
          </button>
        </div>

        {hasCalculated && (
          <div className="gpa-result">
            <h4>GPA: {calculatedGpa.toFixed(2)}</h4>
          </div>
        )}
      </div>
    </div>
  );
};

export default GradeCalculator;
