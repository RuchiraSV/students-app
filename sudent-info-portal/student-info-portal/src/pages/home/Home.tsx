import React from 'react';
import StudentForm from '../../scenes/student-creation/StudentForm.tsx';

const Home: React.FC = () => {
    return (
        <div className="homeContainer">
            <StudentForm />
        </div>
    );
};

export default Home;
